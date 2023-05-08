import os
from shutil import copy
import pandas as pd
import requests
import json as gson

from flask import Flask, render_template_string
import folium
from folium.plugins import Draw

app = Flask(__name__)

directory_temp = "C:/Users/Utilisateur/Downloads/data.geojson"
geojson_file = "./geojson/data.geojson"

class My_shape():
    def load_folium(self):
        m = folium.Map(location=[-21.6166700, 166.2166700], zoom_start=17)
        Draw(
            export=True,
            position="topleft",
            draw_options={
                "polyline": True,
                "rectangle": True,
                "circle": False,
                "circlemarker": False,
            },
            edit_options={"poly": {"allowIntersection": False}},
        ).add_to(m)

        folium.TileLayer(
            tiles='https://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}',
            attr='Esri',
            name='Esri Satellite',
            overlay=False,
            control=True
        ).add_to(m)

        return m


def copy_data():
    copy(directory_temp, geojson_file)
    os.remove(directory_temp)

def transform_geojson():
    datas = pd.read_json(geojson_file)
    my_list = []
    for gpsPoint in datas['features']:
        for point in gpsPoint["geometry"]["coordinates"]:
            for p in point:
                my_list.append(p)
    return my_list


def send_to_back():
    copy_data()
    gps_point = transform_geojson()
    json = ""
    nic = ""
    nbre = 0
    for pointx, pointy in gps_point :
        nbre+=1
        nic = '{"id":'+ str(nbre) +',"latitude":'+ str(pointx).replace(".","") +',"longitude":'+ str(pointy).replace(".","") +'},'
        json += nic
    json_str = "{\"ares\": 1000,\"gpsPoint\": [" + json[:-1] + "],\"proprietaire\": \"Tokotoko\"}"
    back_url = "http://localhost:8080/smartContract/"
    data = gson.loads(json_str)
    requests.post(back_url,json=data)

@app.route("/map")
def fullscreen():
    m = My_shape().load_folium()
    send_to_back()
    return m.get_root().render()



# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    app.run(debug=True)

# See PyCharm help at https://www.jetbrains.com/help/pycharm/

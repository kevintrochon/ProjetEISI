pragma solidity ^0.8.18;

contract BailRural {

  struct LandInformation {
    string owner;
    int area;
    int256[] gpsPoints;
  }

  mapping (address => LandInformation) lands;

  event LandRecorded(
    address indexed _address,
    string _owner,
    int _area,
    int256[] _gpsPoints
  );

  function recordLand(string memory _owner, int _area, int256[] memory _gpsPoints) public {
    lands[msg.sender].owner = _owner;
    lands[msg.sender].area = _area;
    lands[msg.sender].gpsPoints = _gpsPoints;
    emit LandRecorded(msg.sender, _owner, _area, _gpsPoints);
  }

  function getLandInformation(address _address) public view returns (string memory, int, int256[] memory) {
    return (lands[_address].owner, lands[_address].area, lands[_address].gpsPoints);
  }

}

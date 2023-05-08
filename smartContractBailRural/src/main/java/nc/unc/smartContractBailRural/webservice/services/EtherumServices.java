package nc.unc.smartContractBailRural.webservice.services;

import nc.unc.smartContractBailRural.entity.GpsPoint;
import nc.unc.smartContractBailRural.entity.SmartContract;
import nc.unc.smartContractBailRural.smartContractBailRural.BailRural;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EtherumServices {

    private static final String RPC_SERVER_URL = "http://localhost:7545";

    private static final String PRIVATE_KEY = "0x1b61a7d9f2192c1d85285fe8ec4e879c656dbcc41223b01280c531f3b3352ce4";

    private static final String CONTRACT_OWNER_ADDRESS = "0xca51B12eEe35BAF6AF8339BEddb8A10315D6F4BE";

    private Web3j web3j;

    private Credentials credentials;

    public EtherumServices() {
        this.web3j = Web3j.build(new HttpService(RPC_SERVER_URL));
        this.credentials = Credentials.create(PRIVATE_KEY);
    }

    public void sendSmartContract(SmartContract smartContract) throws Exception {
        BailRural contract = BailRural.deploy(
                web3j,
                credentials,
                ManagedTransaction.GAS_PRICE,
                Contract.GAS_LIMIT
        ).send();
        System.out.println("Contract deployed at: " + contract.getContractAddress());
        List<BigInteger> data = smartContract.getGpsPoints().stream().map(GpsPoint::getLatitude).collect(Collectors.toList());
        data.addAll(smartContract.getGpsPoints().stream().map(GpsPoint::getLongitude).collect(Collectors.toList()));
        contract.recordLand(smartContract.getProprietaire(),smartContract.getAres(),data).send();
    }
}

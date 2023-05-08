package nc.unc.smartContractBailRural.smartContractBailRural;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class BailRural extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50610651806100206000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c806330e1b50d1461003b5780639585029814610050575b600080fd5b61004e610049366004610348565b61007b565b005b61006361005e366004610409565b61010b565b60405161007293929190610439565b60405180910390f35b336000908152602081905260409020610094848261055b565b50336000908152602081815260409091206001810184905582516100c092600290920191840190610221565b50336001600160a01b03167ffa161e3d229863090f281a03021d952c8910f7e66b8d31016e4af4827272ecf58484846040516100fe93929190610439565b60405180910390a2505050565b6001600160a01b038116600090815260208190526040812060018101548154606093928492909160028301908390610142906104d2565b80601f016020809104026020016040519081016040528092919081815260200182805461016e906104d2565b80156101bb5780601f10610190576101008083540402835291602001916101bb565b820191906000526020600020905b81548152906001019060200180831161019e57829003601f168201915b505050505092508080548060200260200160405190810160405280929190818152602001828054801561020d57602002820191906000526020600020905b8154815260200190600101908083116101f9575b505050505090509250925092509193909250565b82805482825590600052602060002090810192821561025c579160200282015b8281111561025c578251825591602001919060010190610241565b5061026892915061026c565b5090565b5b80821115610268576000815560010161026d565b634e487b7160e01b600052604160045260246000fd5b604051601f8201601f1916810167ffffffffffffffff811182821017156102c0576102c0610281565b604052919050565b600082601f8301126102d957600080fd5b8135602067ffffffffffffffff8211156102f5576102f5610281565b8160051b610304828201610297565b928352848101820192828101908785111561031e57600080fd5b83870192505b8483101561033d57823582529183019190830190610324565b979650505050505050565b60008060006060848603121561035d57600080fd5b833567ffffffffffffffff8082111561037557600080fd5b818601915086601f83011261038957600080fd5b813560208282111561039d5761039d610281565b6103af601f8301601f19168201610297565b82815289828487010111156103c357600080fd5b82828601838301376000928101820192909252909550860135935060408601359150808211156103f257600080fd5b506103ff868287016102c8565b9150509250925092565b60006020828403121561041b57600080fd5b81356001600160a01b038116811461043257600080fd5b9392505050565b606081526000845180606084015260005b81811015610467576020818801810151608086840101520161044a565b506000608082850181018290526020808601889052601f909301601f19168501858103820160408701528651918101829052868401939160a0909101905b808410156104c557845182529382019360019390930192908201906104a5565b5098975050505050505050565b600181811c908216806104e657607f821691505b60208210810361050657634e487b7160e01b600052602260045260246000fd5b50919050565b601f82111561055657600081815260208120601f850160051c810160208610156105335750805b601f850160051c820191505b818110156105525782815560010161053f565b5050505b505050565b815167ffffffffffffffff81111561057557610575610281565b6105898161058384546104d2565b8461050c565b602080601f8311600181146105be57600084156105a65750858301515b600019600386901b1c1916600185901b178555610552565b600085815260208120601f198616915b828110156105ed578886015182559484019460019091019084016105ce565b508582101561060b5787850151600019600388901b60f8161c191681555b5050505050600190811b0190555056fea2646970667358221220f9b0d6a0296520ce1853c467405443a04a56f8e1e2b5144d0e3db9f338b6088864736f6c63430008130033";

    public static final String FUNC_GETLANDINFORMATION = "getLandInformation";

    public static final String FUNC_RECORDLAND = "recordLand";

    public static final Event LANDRECORDED_EVENT = new Event("LandRecorded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}, new TypeReference<DynamicArray<Int256>>() {}));
    ;

    @Deprecated
    protected BailRural(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BailRural(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected BailRural(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected BailRural(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<LandRecordedEventResponse> getLandRecordedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LANDRECORDED_EVENT, transactionReceipt);
        ArrayList<LandRecordedEventResponse> responses = new ArrayList<LandRecordedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LandRecordedEventResponse typedResponse = new LandRecordedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._address = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._area = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._gpsPoints = (List<BigInteger>) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LandRecordedEventResponse> landRecordedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, LandRecordedEventResponse>() {
            @Override
            public LandRecordedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LANDRECORDED_EVENT, log);
                LandRecordedEventResponse typedResponse = new LandRecordedEventResponse();
                typedResponse.log = log;
                typedResponse._address = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._area = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._gpsPoints = (List<BigInteger>) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<LandRecordedEventResponse> landRecordedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LANDRECORDED_EVENT));
        return landRecordedEventObservable(filter);
    }

    public RemoteCall<TransactionReceipt> getLandInformation(String _address) {
        final Function function = new Function(
                FUNC_GETLANDINFORMATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_address)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> recordLand(String _owner, BigInteger _area, List<BigInteger> _gpsPoints) {
        final Function function = new Function(
                FUNC_RECORDLAND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_owner), 
                new org.web3j.abi.datatypes.generated.Int256(_area), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Int256>(
                        org.web3j.abi.Utils.typeMap(_gpsPoints, org.web3j.abi.datatypes.generated.Int256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<BailRural> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BailRural.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BailRural> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BailRural.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<BailRural> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BailRural.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BailRural> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BailRural.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static BailRural load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BailRural(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static BailRural load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BailRural(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static BailRural load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new BailRural(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static BailRural load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new BailRural(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class LandRecordedEventResponse {
        public Log log;

        public String _address;

        public String _owner;

        public BigInteger _area;

        public List<BigInteger> _gpsPoints;
    }
}

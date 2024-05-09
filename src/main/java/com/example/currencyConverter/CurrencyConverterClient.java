/*

package com.example.currencyConverter;


import com.example.Protos.convertCurrency.CurrencyConverterGrpc;
import com.example.Protos.convertCurrency.convertCurrencyProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class CurrencyConverterClient {

    public CurrencyConverterClient(String host, int port, float amount, String currencyToConvert) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        CurrencyConverterGrpc.CurrencyConverterBlockingStub stub = CurrencyConverterGrpc.newBlockingStub(channel);
        convertCurrencyProto.ConvertCurrencyRequest request = convertCurrencyProto.ConvertCurrencyRequest.newBuilder().setAmount(amount).setToCurrency(currencyToConvert).setFromCurrency("USD").build();
        convertCurrencyProto.ConvertCurrencyReply reply = stub.convertCurrency(request);

        System.out.println(reply);
        channel.shutdownNow();
    }



    private final ManagedChannel channel;
    private final CurrencyConverterGrpc.CurrencyConverterBlockingStub blockingStub;
    public CurrencyConverterClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        this.blockingStub = CurrencyConverterGrpc.newBlockingStub(channel);
    }

    public double convertCurrency(float amount, String fromCurrency, String toCurrency) {
        convertCurrencyProto.ConvertCurrencyRequest request = convertCurrencyProto.ConvertCurrencyRequest.newBuilder()
                .setAmount(amount)
                .setFromCurrency(fromCurrency)
                .setToCurrency(toCurrency)
                .build();

        convertCurrencyProto.ConvertCurrencyReply reply = blockingStub.convertCurrency(request);
        return reply.getConvertedAmount();
    }

/*
    public static void main(String[] args) {
        CurrencyConverterClient client = new CurrencyConverterClient("localhost", 5120, 200, "EUR");
    }


} */
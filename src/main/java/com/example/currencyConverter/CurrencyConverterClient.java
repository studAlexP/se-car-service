package com.example.currencyConverter;

import convertCurrency.ConvertCurrency;
import convertCurrency.CurrencyConverterGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class CurrencyConverterClient {

    private final ManagedChannel channel;
    private final CurrencyConverterGrpc.CurrencyConverterBlockingStub blockingStub;

    public CurrencyConverterClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        blockingStub = CurrencyConverterGrpc.newBlockingStub(this.channel);
    }

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        ConvertCurrency.ConvertCurrencyRequest request = ConvertCurrency.ConvertCurrencyRequest.newBuilder()
                .setAmount(amount)
                .setFromCurrency(fromCurrency)
                .setToCurrency(toCurrency)
                .build();
        try {
            ConvertCurrency.ConvertCurrencyReply reply = blockingStub.convertCurrency(request);
            return reply.getConvertedAmount();
        } catch (StatusRuntimeException e) {
            System.err.println(e.getStatus().getDescription());
            return -1;
        }
    }
}

package com.example.liquibase.awsUtil;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.GetParameterResponse;
import software.amazon.awssdk.services.ssm.model.SsmException;

public class AmazonGetParameter {

    public static String getParameter(String paraName) {

        Region region = Region.EU_CENTRAL_1;
        SsmClient ssmClient = SsmClient.builder()
                .region(region)
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();

        String value = getParaValue(ssmClient, paraName);
        ssmClient.close();
        return value;
    }

    private static String getParaValue(SsmClient ssmClient, String paraName) {
        String para = "";
        try {
            GetParameterRequest parameterRequest = GetParameterRequest.builder()
                    .name(paraName)
                    .build();

            GetParameterResponse parameterResponse = ssmClient.getParameter(parameterRequest);
            System.out.println("The parameter value is "+parameterResponse.parameter().value());
            para = parameterResponse.parameter().value();

        } catch (SsmException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return para;
    }
}
package com.company.fitdonation.api;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.util.Utils;
import com.google.api.client.util.DateTime;
import com.google.api.services.fitness.Fitness;
import com.google.api.services.fitness.FitnessScopes;
import com.google.api.services.fitness.model.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class GoogleFitService {

    private static final String DT_STEPS = "com.google.step_count.delta";
    private static final DataTypeField FIELD_STEPS =
            new DataTypeField()
                    .setName("steps")
                    .setFormat("integer");
    private static final List<DataTypeField> STEPS_FIELDS = Arrays.asList(FIELD_STEPS);
    public static final DataType DATA_TYPE_STEPS =
            new DataType()
                    .setName(DT_STEPS)
                    .setField(STEPS_FIELDS);

    public void getInfo() throws IOException {
        GoogleCredential credential = new GoogleCredential.Builder()
                .setTransport(Utils.getDefaultTransport())
                .setServiceAccountScopes(Collections.singletonList(FitnessScopes.FITNESS_ACTIVITY_READ))
                .setJsonFactory(Utils.getDefaultJsonFactory())
                .setClientSecrets("927004208684-fclap120oe3a3d2ue8f7n2ng94ufuki7.apps.googleusercontent.com",
                        "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")
                .build();

        Fitness service = new Fitness.Builder(Utils.getDefaultTransport(), Utils.getDefaultJsonFactory(), credential)
                .setApplicationName("fitdonation")
                .build();

        DataSource content = new DataSource().setDataType(DATA_TYPE_STEPS);
        Fitness.Users.DataSources.Create request = service.users().dataSources().create("me", content);

        request.execute();
    }
}

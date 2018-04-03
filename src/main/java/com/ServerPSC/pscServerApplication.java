package com.ServerPSC;

import com.ServerPSC.resources.getCityPsc;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class pscServerApplication extends Application<pscServerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new pscServerApplication().run(args);
    }

    @Override
    public String getName() {
        return "pscServer";
    }

    @Override
    public void initialize(final Bootstrap<pscServerConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final pscServerConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(new getCityPsc());
    }

}

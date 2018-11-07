package chh;

import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.tools.DummyAgent.DummyAgent;

public class AgentTry extends Agent {
    public static void main(String[] args) {

// Initialize JADE platform

        jade.core.Runtime rt = jade.core.Runtime.instance();

        Profile profile = new ProfileImpl();

        profile.setParameter(Profile.PLATFORM_ID, "ULBS");

        profile.setParameter(Profile.CONTAINER_NAME, "Laborator SMA");

        profile.setParameter(Profile.GUI, "true");

        jade.wrapper.AgentContainer mainContainer = rt.createMainContainer(profile);

// Initialize agents

        jade.wrapper.AgentController controller;

        try {

            controller = mainContainer.acceptNewAgent("Dummy1", new DummyAgent());

                    controller.start();

            controller = mainContainer.acceptNewAgent("Ping1", new examples.PingAgent.PingAgent());

                    controller.start();

        } catch (jade.wrapper.StaleProxyException e) {

            e.printStackTrace();

        }

    }
}

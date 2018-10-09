package com.yhkx.core.configuration;

import com.ecwid.consul.v1.health.model.Check;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerListFilter;
import org.springframework.cloud.consul.discovery.ConsulServer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomConsulServerFilter implements ServerListFilter<Server> {

    public CustomConsulServerFilter() {
    }

    @Override
    public List<Server> getFilteredListOfServers(List<Server> servers) {
        List<Server> filtered = new ArrayList();
        Iterator var3 = servers.iterator();

        while (var3.hasNext()) {
            Server server = (Server) var3.next();
            if (server instanceof ConsulServer) {
                ConsulServer consulServer = (ConsulServer) server;
                if (isPassingChecks(consulServer)) {
                    filtered.add(server);
                }
            } else {
                filtered.add(server);
            }
        }

        return filtered;
    }

    private boolean isPassingChecks(ConsulServer consulServer) {
        for (Check check : consulServer.getHealthService().getChecks()) {
            if (!check.getCheckId().equals("serfHealth") && check.getStatus() == Check.CheckStatus.PASSING) {
                return true;
            }
        }
        return false;
    }
}
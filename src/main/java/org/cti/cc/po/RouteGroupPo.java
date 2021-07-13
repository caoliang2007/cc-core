package org.cti.cc.po;

import org.cti.cc.entity.RouteGetway;
import org.cti.cc.entity.RouteGroup;

import java.util.List;

/**
 * 路由网关组
 */
public class RouteGroupPo  extends RouteGroup {

    /**
     * 网关列表
     */
    private List<RouteGetway> routeGetways;

    public List<RouteGetway> getRouteGetways() {
        return routeGetways;
    }

    public void setRouteGetways(List<RouteGetway> routeGetways) {
        this.routeGetways = routeGetways;
    }
}

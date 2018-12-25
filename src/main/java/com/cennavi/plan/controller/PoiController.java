package com.cennavi.plan.controller;

import com.cennavi.plan.model.BasePoi;
import com.cennavi.plan.service.IBasePoiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/planService/poi")
public class PoiController {
    @Resource
    IBasePoiService basePoiService;

    @RequestMapping("/findPoi")
    public @ResponseBody List<BasePoi> findPoi()
    {
        List<BasePoi> basePoiList = basePoiService.findPoi();
        return basePoiList;
    }

    @RequestMapping("/findPoiByPid")
    public @ResponseBody List<BasePoi> findPoiByPid(@RequestParam (name="pid",required = false) String pid)
    {
        List<BasePoi> basePoiList = basePoiService.findSubPoiByPID(pid);
        return basePoiList;
    }
}

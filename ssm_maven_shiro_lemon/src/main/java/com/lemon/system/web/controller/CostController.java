package com.lemon.system.web.controller;

import com.github.pagehelper.PageInfo;
import com.lemon.pojo.TCost;
import com.lemon.system.service.TCostService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cost/")
public class CostController {

    @Autowired
    private TCostService tCostService;




    @GetMapping("addCost")

    public String addCost() {
        return "system/cost/cost_add";
    }

    @PostMapping("addCost")
    public String addCostEnd( TCost cost, Model model ) {
        int count = tCostService.insert ( cost );
        model.addAttribute ( "cost", cost );
        if (count > 0) {
            model.addAttribute ( "tip", "添加费用成功" );
        } else {
            model.addAttribute ( "tip", "添加费用失败" );
        }
        return "system/cost/cost_add";
    }


    @PostMapping("deleteMultiCost")
    public String deleteMultiCost( Integer[] ids ) {
        tCostService.deleteMultiCost ( ids );
        return "redirect:/system/costQuery";
    }


    @GetMapping("updateCost/{costid}")
    public String updateCost( Model model, @PathVariable Integer costid ) {
        TCost cost = tCostService.selectByPrimaryKey ( costid );
        model.addAttribute ( "cost", cost );
        return "system/cost/cost_update";
    }

    @PostMapping("updateCost")
    public String updateCost( Model model, TCost cost ) {
        Boolean flag = tCostService.updateByPrimaryKey ( cost );
        if (flag) {
                model.addAttribute ( "tip","修改费用成功" );
        }else{
            model.addAttribute ( "tip","修改费用失败" );
        }
        model.addAttribute ( "cost", cost );
        return "system/cost/cost_update";
    }


}

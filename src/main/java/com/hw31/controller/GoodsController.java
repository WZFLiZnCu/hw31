package com.hw31.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hw31.pojo.Goods;
import com.hw31.service.BrandService;
import com.hw31.service.ClassifyService;
import com.hw31.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GoodsController {

    @Autowired
    private GoodsService gs;
    @Autowired
    private ClassifyService cs;
    @Autowired
    private BrandService bs;

    @GetMapping("getall1")
    public String getall1(Model model){
        model.addAttribute("info",gs.getAll());
        return "allgoods";
    }
    @GetMapping("/getall2")
    public String getall2(Model model,Integer pno,Integer psize){
            model.addAttribute("info",gs.getAllGoodsByPage(pno,psize));
            model.addAttribute("bs",bs.getallb(null));
            model.addAttribute("cs",cs.getallc());
            return "allgoods2";
    }
    @GetMapping("/find")
    @ResponseBody
    public IPage<Goods> findGoods(Integer cid, Integer bid, String keyword, String ordercol, Integer order, Integer pno){
        int id1 = cid !=null ? cid: 0 ;
        int id2 = bid !=null ? bid: 0 ;
        int ord = order !=null ? order: 0 ;
        IPage<Goods> page =gs.getGoods(id1,id2,keyword,pno,ordercol,ord);
//        page.getRecords().forEach(System.out::println);
        return page;
    }
    @GetMapping("/find2")
    @ResponseBody
    public IPage<Goods> findGoods2(Integer cid, Integer bid, String keyword,Integer pageno , String ordercol, Integer order ){
        int id1 = cid != null ? cid : 0 ;
        int id2 = bid != null ? bid : 0 ;
        int ord = order != null ? order : 0 ;
        IPage<Goods> page = gs.getGoods2(id1,id2,keyword,pageno,ordercol,ord);
        return page;
    }
    @GetMapping("/find3")
    public String findGoods3(Model model,Integer cid, Integer bid, String keyword,Integer pageno , String ordercol, Integer order ){
        int id1 = cid != null ? cid : 0 ;
        int id2 = bid != null ? bid : 0 ;
        int ord = order != null ? order : 0 ;
        IPage<Goods> page = gs.getGoods2(id1,id2,keyword,pageno,ordercol,ord);
        model.addAttribute("info",page);
        model.addAttribute("cs",cs.getallc());
        model.addAttribute("bs",bs.getallb(null));
        return "goods";
    }
}

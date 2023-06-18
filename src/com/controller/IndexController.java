package com.controller;

import java.io.UnsupportedEncodingException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.*;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.GoodService;
import com.service.TypeService;
import com.util.PageUtil;

/**
 * ǰ̨��ؽӿ�
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private GoodService goodService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private OrderService orderService;


    /**
     * ��ҳ
     *
     * @return
     */
    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        request.setAttribute("flag", 1);
        // ��Ŀ�б�
        List<Types> typeList = typeService.getList();
        List<Map<String, Object>> dataList = new ArrayList<>();
        for (Types type : typeList) {
            Map<String, Object> map = new HashMap<>();
            map.put("type", type);
            map.put("goodList", goodService.getListByType(type.getId(), 1, 15,null,null)); // ȡǰ15��
            dataList.add(map);
        }
        request.setAttribute("dataList", dataList);
        return "/index/index.jsp";
    }

    /**
     * ��Ʒ����
     *
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/type")
    public String type(HttpServletRequest request,
                       @RequestParam(required = false, defaultValue = "0") int id,
                       @RequestParam(required = false, defaultValue = "1") int page,
                       @RequestParam(required = false, defaultValue = "10") int size) throws UnsupportedEncodingException {
        request.setAttribute("type", typeService.get(id));
        request.setAttribute("goodList", goodService.getListByType(id, page, size,null,null));
        request.setAttribute("pageHtml", PageUtil.getPageHtml(request, goodService.getCountByType(id), page, size));
        return "/index/goods.jsp";
    }



    /**
     * ��Ʒ����
     *
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/new")
    public String news(HttpServletRequest request,
                       @RequestParam(required = false, defaultValue = "1") int page,
                       @RequestParam(required = false, defaultValue = "10") int size) throws UnsupportedEncodingException {
        request.setAttribute("flag", 4);
        request.setAttribute("goodList", goodService.getList(page, size,null,null));
        request.setAttribute("pageHtml", PageUtil.getPageHtml(request, goodService.getCount(null,null), page, size));
        return "/index/goods.jsp";
    }

    /**
     * ����
     *
     * @return
     */
    @GetMapping("/search")
    public String search(String search, HttpServletRequest request,
                         @RequestParam(required = false, defaultValue = "1") int page,
                         @RequestParam(required = false, defaultValue = "10") int size) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        search = new String(search.getBytes("utf-8"), "utf-8");
        request.setAttribute("search", search);
        System.out.println(search);
        if (Objects.nonNull(search) && !search.trim().isEmpty()) {
            request.setAttribute("goodList", goodService.getListByName(search, page, size));
            request.setAttribute("pageHtml", PageUtil.getPageHtml(request, goodService.getTotalByName(search), page, size));
        }
        return "/index/goods.jsp";
    }

    /**
     * ��Ʒ����
     *
     * @return
     */
    @GetMapping("/detail")
    public String detail(int id, HttpServletRequest request) {
        request.setAttribute("good", goodService.get(id));
        //-------
        List<Evaluates> evaluates = goodService.getEvaluates(id);
        request.setAttribute("evaluates",evaluates);
        System.out.println(evaluates);
        return "/index/detail.jsp";
    }

    /*
        ��ת����ҳ��
     */
    @GetMapping("/toComment")
    public String toComment(int id,HttpServletRequest request){
        List<Items> itemList = orderService.getItemList(id);
        for (Items item: itemList){
            Goods goods = goodService.get(item.getGoodId());
            Evaluates evaluate = goodService.getCommentByOidAndGid(item.getGoodId(), item.getOrderId());
            item.setGood(goods);
            if (evaluate != null){
                item.setEvaluates(evaluate);
                item.setEvaluateFlag(true);
            }
        }
        System.out.println(itemList);
        request.setAttribute("itemList",itemList);
        return "/index/comment.jsp";
    }

    /*
        ��������
     */
    @PostMapping("/addComment")
    public String addComment(Evaluates evaluates){
        evaluates.setContent(evaluates.getContent().trim());
        evaluates.setSystime(new Date());
        goodService.addComment(evaluates);
        boolean isAllEvaluate = goodService.judgeIsAllEvaluate(evaluates.getOid());
        System.out.println("isAllEvaluate:"+isAllEvaluate);
        //�������������Ʒȫ�����ۣ���������״̬��Ϊ�����
        if(isAllEvaluate){
            orderService.finish(evaluates.getOid());
        }
        return "redirect:/index/toComment?id="+evaluates.getOid();
    }

}
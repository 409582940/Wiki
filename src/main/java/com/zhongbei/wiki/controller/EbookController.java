package com.zhongbei.wiki.controller;


import com.zhongbei.wiki.domain.Ebook;
import com.zhongbei.wiki.resp.CommonResp;
import com.zhongbei.wiki.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Autowired
    EbookService ebookService;

    @GetMapping("/list")
    public CommonResp<List<Ebook>> list(String name) {
        CommonResp<List<Ebook>> resp = new CommonResp<>();
        List<Ebook> list = ebookService.list(name);
        resp.setContent(list);
        return resp;
    }
}

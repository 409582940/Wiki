package com.zhongbei.wiki.controller;


import com.zhongbei.wiki.req.EbookReq;
import com.zhongbei.wiki.resp.CommonResp;
import com.zhongbei.wiki.resp.EbookResp;
import com.zhongbei.wiki.resp.PageResp;
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
    public CommonResp<PageResp<EbookResp>> list(EbookReq req) {
        CommonResp<PageResp<EbookResp>> resp = new CommonResp<>();
        PageResp<EbookResp> list = ebookService.list(req);
        resp.setContent(list);
        return resp;
    }
}

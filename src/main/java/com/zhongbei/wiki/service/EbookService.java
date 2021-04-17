package com.zhongbei.wiki.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.autoconfigure.PageHelperProperties;
import com.zhongbei.wiki.domain.Ebook;
import com.zhongbei.wiki.domain.EbookExample;
import com.zhongbei.wiki.mapper.EbookMapper;
import com.zhongbei.wiki.req.EbookReq;
import com.zhongbei.wiki.resp.CommonResp;
import com.zhongbei.wiki.resp.EbookResp;
import com.zhongbei.wiki.resp.PageResp;
import com.zhongbei.wiki.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.github.pagehelper.PageHelper;

import java.util.List;

@Service
public class EbookService {

    @Autowired
    EbookMapper ebookMapper;

    private static final Logger LOG = LoggerFactory.getLogger(EbookService.class);

    public PageResp<EbookResp> list(EbookReq req) {


        EbookExample example = new EbookExample();
        EbookExample.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%" + req.getName() + "%");
        }
        PageHelper.startPage(req.getNum(), req.getSize());
        List<Ebook> list = ebookMapper.selectByExample(example);
        PageInfo<Ebook> pageInfo = new PageInfo<>(list);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

        List<EbookResp> list2 = CopyUtil.copyList(list, EbookResp.class);

        PageResp<EbookResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list2);

        return pageResp;

    }


}

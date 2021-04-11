package com.zhongbei.wiki.service;


import com.zhongbei.wiki.domain.Ebook;
import com.zhongbei.wiki.domain.EbookExample;
import com.zhongbei.wiki.mapper.EbookMapper;
import com.zhongbei.wiki.req.EbookReq;
import com.zhongbei.wiki.resp.CommonResp;
import com.zhongbei.wiki.resp.EbookResp;
import com.zhongbei.wiki.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EbookService {

    @Autowired
    EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req) {
        EbookExample example = new EbookExample();
        EbookExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike("%" + req.getName() + "%");
        List<Ebook> list = ebookMapper.selectByExample(example);
        List<EbookResp> res = CopyUtil.copyList(list, EbookResp.class);
        return res;
    }


}

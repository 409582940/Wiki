package com.zhongbei.wiki.service;


import com.zhongbei.wiki.domain.Ebook;
import com.zhongbei.wiki.domain.EbookExample;
import com.zhongbei.wiki.mapper.EbookMapper;
import com.zhongbei.wiki.resp.CommonResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EbookService {

    @Autowired
    EbookMapper ebookMapper;

    public List<Ebook> list(String name) {
        EbookExample example = new EbookExample();
        EbookExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike("%" + name + "%");
        return ebookMapper.selectByExample(example);
    }


}

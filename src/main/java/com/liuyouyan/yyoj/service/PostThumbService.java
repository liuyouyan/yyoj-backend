package com.liuyouyan.yyoj.service;

import com.liuyouyan.yyoj.model.entity.PostThumb;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liuyouyan.yyoj.model.entity.User;

/**
 * 帖子点赞服务
 *
 * @author <a href="https://liuyouyan.com">刘有颜</a>
 * @from <a href="https://liuyouyan.com">刘有颜的博客</a>
 */
public interface PostThumbService extends IService<PostThumb> {

    /**
     * 点赞
     *
     * @param postId
     * @param loginUser
     * @return
     */
    int doPostThumb(long postId, User loginUser);

    /**
     * 帖子点赞（内部服务）
     *
     * @param userId
     * @param postId
     * @return
     */
    int doPostThumbInner(long userId, long postId);
}

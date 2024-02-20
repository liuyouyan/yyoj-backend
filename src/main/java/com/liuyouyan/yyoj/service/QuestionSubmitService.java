package com.liuyouyan.yyoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liuyouyan.yyoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.liuyouyan.yyoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.liuyouyan.yyoj.model.entity.QuestionSubmit;
import com.liuyouyan.yyoj.model.entity.User;
import com.liuyouyan.yyoj.model.vo.QuestionSubmitVO;

/**
 * <p>
 * 题目提交 服务类
 * </p>
 *
 * @author 刘有颜
 * @since 2024-02-17
 */
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 提交题目
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 获取查询条件
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 分页获取题目封装
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);

    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);
}

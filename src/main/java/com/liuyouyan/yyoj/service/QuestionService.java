package com.liuyouyan.yyoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liuyouyan.yyoj.model.dto.question.QuestionQueryRequest;
import com.liuyouyan.yyoj.model.entity.Question;
import com.liuyouyan.yyoj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 题目 服务类
 * </p>
 *
 * @author 刘有颜
 * @since 2024-02-17
 */
public interface QuestionService extends IService<Question> {

    /**
     * 校验
     * @param question
     * @param add
     */
    void validQuestion(Question question, boolean add);

    /**
     * 获取题目封装
     * @param question
     * @param request
     * @return
     */
    QuestionVO getQuestionVO(Question question, HttpServletRequest request);

    /**
     * 获取查询条件
     * @param questionQueryRequest
     * @return
     */
    QueryWrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest);

    /**
     * 分页获取题目封装
     * @param page
     * @param request
     * @return
     */
    Page<QuestionVO> getQuestionVOPage(Page<Question> page, HttpServletRequest request);
}

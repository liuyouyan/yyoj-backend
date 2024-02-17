package com.liuyouyan.yyoj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuyouyan.yyoj.mapper.QuestionMapper;
import com.liuyouyan.yyoj.model.entity.Question;
import com.liuyouyan.yyoj.service.IQuestionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 题目 服务实现类
 * </p>
 *
 * @author 刘有颜
 * @since 2024-02-17
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

}

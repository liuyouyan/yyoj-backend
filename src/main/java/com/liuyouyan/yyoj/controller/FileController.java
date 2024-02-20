package com.liuyouyan.yyoj.controller;

import cn.hutool.core.io.FileUtil;
import com.liuyouyan.yyoj.common.exception.ErrorCode;
import com.liuyouyan.yyoj.common.enumeration.FileUploadBizEnum;
import com.liuyouyan.yyoj.common.exception.BusinessException;
import com.liuyouyan.yyoj.common.result.BaseResponse;
import com.liuyouyan.yyoj.common.result.ResultUtils;
import com.liuyouyan.yyoj.common.utils.AliOssUtil;
import com.liuyouyan.yyoj.model.dto.file.UploadFileRequest;
import com.liuyouyan.yyoj.model.entity.User;
import com.liuyouyan.yyoj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 文件接口
 *
 * @author <a href="https://liuyouyan.com">刘有颜</a>
 * @from <a href="https://liuyouyan.com">刘有颜的博客</a>
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

    @Resource
    private UserService userService;

    @Resource
    private AliOssUtil aliOssUtil;

    /**
     * 文件上传
     *
     * @param multipartFile
     * @param uploadFileRequest
     * @param request
     * @return
     */
    @PostMapping("/upload")
    public BaseResponse<String> uploadFile(@RequestPart("file") MultipartFile multipartFile,
                                           UploadFileRequest uploadFileRequest, HttpServletRequest request) {
        log.info("文件上传:{}", multipartFile);
        String biz = uploadFileRequest.getBiz();
        FileUploadBizEnum fileUploadBizEnum = FileUploadBizEnum.getEnumByValue(biz);
        if (fileUploadBizEnum == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        validFile(multipartFile, fileUploadBizEnum);
        User loginUser = userService.getLoginUser(request);
        // 文件目录：根据业务、用户来划分
        String uuid = RandomStringUtils.randomAlphanumeric(8);
        String filename = uuid + "-" + multipartFile.getOriginalFilename();
        String filepath = String.format("%s/%s/%s", fileUploadBizEnum.getValue(), loginUser.getId(), filename);

        try {
            // 上传文件
            String fileName = aliOssUtil.upload(multipartFile.getBytes(), filepath);
            // 返回可访问地址
            return ResultUtils.success(fileName);
        } catch (Exception e) {
            log.error("file upload error, filepath = " + filepath, e);
        }
        throw new BusinessException(ErrorCode.SYSTEM_ERROR, "上传失败");
    }

    /**
     * 校验文件
     *
     * @param multipartFile
     * @param fileUploadBizEnum 业务类型
     */
    private void validFile(MultipartFile multipartFile, FileUploadBizEnum fileUploadBizEnum) {
        // 文件大小
        long fileSize = multipartFile.getSize();
        // 文件后缀
        String fileSuffix = FileUtil.getSuffix(multipartFile.getOriginalFilename());
        final long ONE_M = 1024 * 1024L;
        if (FileUploadBizEnum.USER_AVATAR.equals(fileUploadBizEnum)) {
            if (fileSize > ONE_M) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "文件大小不能超过 1M");
            }
            if (!Arrays.asList("jpeg", "jpg", "svg", "png", "webp").contains(fileSuffix)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "文件类型错误");
            }
        }
    }
}

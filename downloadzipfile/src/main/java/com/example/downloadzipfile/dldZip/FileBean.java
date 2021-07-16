package com.example.downloadzipfile.dldZip;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * 文件实体类
 * */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileBean implements Serializable{

    private static final long serialVersionUID = -5452801884470115159L;

    private Integer fileId;//主键

    private String filePath;//文件保存路径

    private String fileName;//文件保存名称

}
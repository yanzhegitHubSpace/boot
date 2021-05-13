package com.kejw.mybatisdemo.generator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
 
import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
 
 
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class ServiceControllerPlugin extends PluginAdapter{

	public boolean validate(List<String> warnings) {
		return true;
	}
 
 
	@Override
	public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
 
 
		String javaRepositoryPackage = this.getContext().getJavaClientGeneratorConfiguration().getTargetPackage();
		String javaMapperType = introspectedTable.getMyBatis3JavaMapperType();
		String topPackage = javaRepositoryPackage.substring(0, javaRepositoryPackage.lastIndexOf('.'));
		String javaClassName = javaMapperType.substring(javaMapperType.lastIndexOf('.') + 1, javaMapperType.length()).replace("Mapper", "");
		String targetProject = this.getContext().getJavaClientGeneratorConfiguration().getTargetProject();
 
 
		Map<String, String> root = new HashMap<String, String>();
		root.put("topPackage", topPackage);
		root.put("EntityName", javaClassName);
		root.put("entityName", new StringBuilder().append(Character.toLowerCase(javaClassName.charAt(0)))
				.append(javaClassName.substring(1)).toString());
 
		genService(targetProject, topPackage, javaClassName, root);
		genServiceImpl(targetProject, topPackage, javaClassName, root);
		genController(targetProject, topPackage, javaClassName, root);
 
 
		return null;
	}
 
	@SuppressWarnings("deprecation")
	private void genService(String targetProject, String topPackage, String javaClassName, Map<String, String> root) {
		String dirPath = targetProject + "/" + topPackage.replaceAll("\\.", "/") + "/service";
		String filePath = targetProject + "/" + topPackage.replaceAll("\\.", "/") + "/service/" + javaClassName
				+ "Service.java";
		File dir = new File(dirPath);
		File file = new File(filePath);
		if (file.exists()) {
			System.err.println(file + " already exists, it was skipped.");
			return;
		} else {
			try {
				dir.mkdirs();
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 
 
		Configuration cfg = new Configuration();
		cfg.setClassForTemplateLoading(this.getClass(), "/");
		cfg.setObjectWrapper(new DefaultObjectWrapper());
 
 
		try {
			Template temp = cfg.getTemplate("EntityService.ftl");
			Writer out = new OutputStreamWriter(new FileOutputStream(file));
			temp.process(root, out);
			out.flush();
		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
 
 
	}
 
	@SuppressWarnings("deprecation")
	private void genServiceImpl(String targetProject, String topPackage, String javaClassName, Map<String, String> root) {
		String dirPath = targetProject + "/" + topPackage.replaceAll("\\.", "/") + "/service/impl";
		String filePath = targetProject + "/" + topPackage.replaceAll("\\.", "/") + "/service/impl/" + javaClassName
				+ "ServiceImpl.java";
		File dir = new File(dirPath);
		File file = new File(filePath);
		if (file.exists()) {
			System.err.println(file + " already exists, it was skipped.");
			return;
		} else {
			try {
				dir.mkdirs();
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 
 
		Configuration cfg = new Configuration();
		cfg.setClassForTemplateLoading(this.getClass(), "/");
		cfg.setObjectWrapper(new DefaultObjectWrapper());
 
 
		try {
			Template temp = cfg.getTemplate("EntityServiceImpl.ftl");
			Writer out = new OutputStreamWriter(new FileOutputStream(file));
			temp.process(root, out);
			out.flush();
		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
 
 
	}
 
 
	@SuppressWarnings("deprecation")
	private void genController(String targetProject, String topPackage, String javaClassName,
			Map<String, String> root) {
		String dirPath = targetProject + "/" + topPackage.replaceAll("\\.", "/") + "/controller";
		String filePath = targetProject + "/" + topPackage.replaceAll("\\.", "/") + "/controller/" + javaClassName
				+ "Controller.java";
		File dir = new File(dirPath);
		File file = new File(filePath);
		if (file.exists()) {
			System.err.println(file + " already exists, it was skipped.");
			return;
		} else {
			try {
				dir.mkdirs();
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 
 
		Configuration cfg = new Configuration();
		cfg.setClassForTemplateLoading(this.getClass(), "/");
		cfg.setObjectWrapper(new DefaultObjectWrapper());
 
 
		try {
			Template temp = cfg.getTemplate("EntityController.ftl");
			Writer out = new OutputStreamWriter(new FileOutputStream(file));
			temp.process(root, out);
			out.flush();
		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
 
 
	}
}

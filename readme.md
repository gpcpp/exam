# 基于SpringbBoot的网上考试管理系统

## 介绍
 ### 功能简介

- 支持单选题、多选题、判断题

- 支持学生(student)、教师(teacher)、管理员(admin)三种角色

	- 学生：参加考试和查看我的考试
	- 教师：学生的所有权限+创建/编辑题目+创建/编辑考试
	- 管理员：教师的所有权限+管理用户

###  软件架构

- 后端采用SpringBoot+JPA++Swagger2+JWT校验,根据不同用户的权限返回给用户不同的数据
- 前端采用Vue+AntDesign,组件化拆分，封装了很多年公共组件，方便维护和二次开发

package com.fly.service.impl;


import com.fly.common.model.mapper.UserMapper;
import com.fly.user.model.ClassRoom;
import com.fly.user.model.Student;
import com.fly.user.model.Teacher;
import com.fly.user.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by jinxiaofei on 16/10/17.
 */
@Controller
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;


    @Override
    public Student find(int personId, int bid) {
        LOGGER.info("将要进行查询操作,personId:{},bid{}", personId, bid);
        //        return userMapper.find(personId,bid);
        return null;
    }


    @Override
    /**
     * 第五种。同一个类之间，非事务的方法调用事务的方法，异常是不会回滚的
     * 这种也是最常见的一个问题
     */ public Long save(Student p, Teacher teacher, ClassRoom classRoom) {


        Long classId =   saveClassV3(classRoom);
        teacher.setCId(classId);
        //这种强制获取代理类的方式也可以引起回滚
        Long tid =((UserServiceImpl) AopContext.currentProxy()).saveTeacher(teacher);
        //这种方式是不会引起回滚的
        //Long tid=saveTeacher(teacher);

        p.setTId(tid);
        p.setCId(classId);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("开始进行员工的添加:{}", p);
        }
        userMapper.save(p);
        if (p.getId() > 5) {
            throw new RuntimeException("can not insert student");
        }
        return p.getId();
    }


    @Transactional
    //第三种，默认的回滚异常只回滚unchecked（RuntimeException and Error的子类）
    public Long saveClassV6(ClassRoom classRoom) throws Exception {
        userMapper.saveClassRoom(classRoom);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("教室的添加完成:{}", classRoom);
        }
        if (classRoom.getId() > 3) {
            throw new Exception("can not insert class room ,the id is bigger than 3");

        }
        return classRoom.getId();
    }


    @Transactional(rollbackFor = Exception.class)
    public Long saveClassV7(ClassRoom classRoom) throws Exception {
        userMapper.saveClassRoom(classRoom);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("教室的添加完成:{}", classRoom);
        }
        if (classRoom.getId() > 3) {
            throw new Exception("can not insert class room ,the id is bigger than 3");

        }
        return classRoom.getId();
    }


    @Override
    @Transactional
    public Long saveTeacher(Teacher t) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("开始进行教师的添加的添加:{}", t);
        }
        userMapper.saveTeacher(t);
        if (t.getId() > 5) {
            throw new RuntimeException("can not insert teacher the id is bigger than 5");
        }
        return t.getId();
    }


    @Override
    public Long saveTeacherV2(Teacher t) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("开始进行教师的添加的添加:{}", t);
        }
        userMapper.saveTeacher(t);
        if (t.getId() > 5) {
            throw new RuntimeException("can not insert teacher the id is bigger than 5");
        }
        return t.getId();
    }


    @Override
    //第一种，自己有事务但是被其他没有事务的方法调用
    @Transactional
    public Long saveClass(ClassRoom classRoom) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("开始进行教师的添加:{}", classRoom);
        }
        userMapper.saveClassRoom(classRoom);
        if (classRoom.getId() > 5) {
            throw new RuntimeException("can not insert class room ,the id is bigger than 5");

        }
        return classRoom.getId();
    }


    @Override
    //第第二种，spring的事务级别控制的不对，也不会允许事务
    /*
    TransactionDefinition.PROPAGATION_SUPPORTS：如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
    TransactionDefinition.PROPAGATION_NOT_SUPPORTED：以非事务方式运行，如果当前存在事务，则把当前事务挂起。
    TransactionDefinition.PROPAGATION_NEVER：以非事务方式运行，如果当前存在事务，则抛出异常。
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long saveClassV2(ClassRoom classRoom) {

        userMapper.saveClassRoom(classRoom);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("教室的添加完成:{}", classRoom);
        }
        if (classRoom.getId() > 3) {
            throw new RuntimeException("can not insert class room ,the id is bigger than 3");

        }
        return classRoom.getId();
    }


    @Override
    public Long saveClassV3(ClassRoom classRoom) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("开始进行教室的添加:{}", classRoom);
        }
        userMapper.saveClassRoom(classRoom);
        return classRoom.getId();
    }


    @Transactional
    /**
     * 第四种，如果方法不是public的也不会进行异常回滚
     */
     Long saveClassV4(ClassRoom classRoom) {

        return saveClassV5(classRoom);
    }


    @Transactional
    private Long saveClassV5(ClassRoom classRoom) {
        userMapper.saveClassRoom(classRoom);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("教室的添加完成:{}", classRoom);
        }
        if (classRoom.getId() > 3) {
            throw new RuntimeException("can not insert class room ,the id is bigger than 3");

        }
        return classRoom.getId();
    }


    @Override
    public Student findByName() {
        return userMapper.findByName("飞");
    }
}
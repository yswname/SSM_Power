package cn.com.demo.mybatis.dao;

import java.util.List;

import cn.com.demo.mybatis.entity.DmModul;

public interface IDmModulDAO {
    public void add(DmModul modul);
    public int addModul(DmModul modul);// 主键
    public void update(DmModul modul);
    public void delete(DmModul modul);
    public List<DmModul> findAll();
    public List<DmModul> findAll2();
    public DmModul findById(int id);
}

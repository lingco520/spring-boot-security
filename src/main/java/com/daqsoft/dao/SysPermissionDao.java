package com.daqsoft.dao;

import com.daqsoft.domain.SysPermission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tanggm
 * @date 2017-05-24 11:53
 */
@Repository
public interface SysPermissionDao {
    /**
     * 查询所有
     * @return
     */
    public List<SysPermission> findAll();

    /**
     * 通过userId查询
     * @param userId
     * @return
     */
    public List<SysPermission> findByAdminUserId(Integer userId);
}

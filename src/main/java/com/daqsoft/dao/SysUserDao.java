package com.daqsoft.dao;

import com.daqsoft.domain.SysUser;
import org.springframework.stereotype.Repository;

/**
 * dao 层
 * @author tanggm
 *
 */
@Repository
public interface SysUserDao {
	SysUser findByUserName(String username);
}

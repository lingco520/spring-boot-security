package com.daqsoft.security;

import java.util.ArrayList;
import java.util.List;

import com.daqsoft.dao.SysPermissionDao;
import com.daqsoft.dao.SysUserDao;
import com.daqsoft.domain.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.daqsoft.domain.SysUser;

@Service
public class CustomUserService implements UserDetailsService {

	@Autowired
    SysUserDao userDao;
	@Autowired
	SysPermissionDao sysPermissionDao;
	/**
	 * 重写loadUserByUsername 方法获得 userdetails 类型用户
	 */
	@Override
	public UserDetails loadUserByUsername(String username) {
		// 使用User服务类查询数据用户是否存在,如不存在或密码错误则抛出对应的异常
		SysUser user = userDao.findByUserName(username);
		if(user != null){
			List<SysPermission> sysPermissionList = sysPermissionDao.findByAdminUserId(user.getId());
			List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
			for(SysPermission sysPermission : sysPermissionList){
				if(sysPermission != null && sysPermission.getName() != null){
					GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(sysPermission.getName());
					// 将权限信息添加到 GrantedAuthority对象中，后面进行权限验证时会使用GrantedAuthority对象
					grantedAuthorityList.add(grantedAuthority);
				}
			}
			return new User(user.getUsername(), user.getPassword(), grantedAuthorityList);
		}else{
			throw new UsernameNotFoundException("用户名不存在,请重新输入!");
		}
	}

}

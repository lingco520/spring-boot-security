package com.daqsoft.domain;

import java.util.List;

/**
 * 用户实体
 * @author tanggm
 *
 */
public class SysUser {
	private Integer id;
    private String username;
    private String password;

    private List<SysUser> roles;// 角色集合

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SysUser> getRoles() {
        return roles;
    }

    public void setRoles(List<SysUser> roles) {
        this.roles = roles;
    }
}

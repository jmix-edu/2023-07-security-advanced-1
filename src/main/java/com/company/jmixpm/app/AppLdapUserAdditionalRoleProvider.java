package com.company.jmixpm.app;

import io.jmix.ldap.userdetails.LdapUserAdditionalRoleProvider;
import io.jmix.security.authentication.RoleGrantedAuthority;
import io.jmix.security.model.RowLevelRole;
import io.jmix.security.role.RowLevelRoleRepository;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class AppLdapUserAdditionalRoleProvider implements LdapUserAdditionalRoleProvider {

    private final RowLevelRoleRepository rowLevelRoleRepository;

    public AppLdapUserAdditionalRoleProvider(RowLevelRoleRepository rowLevelRoleRepository) {
        this.rowLevelRoleRepository = rowLevelRoleRepository;
    }

    @Override
    public Set<GrantedAuthority> getAdditionalRoles(DirContextOperations user, String username) {
        String[] roleCodes = user.getStringAttributes("employeeType");
        if (roleCodes == null || roleCodes.length == 0) {
            return Collections.emptySet();
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (String roleCode : roleCodes) {
            RowLevelRole role = rowLevelRoleRepository.findRoleByCode(roleCode);
            if (role != null) {
                RoleGrantedAuthority authority = RoleGrantedAuthority.ofRowLevelRole(role);
                grantedAuthorities.add(authority);
            }
        }

        return grantedAuthorities;
    }
}
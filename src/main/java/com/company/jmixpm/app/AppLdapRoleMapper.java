package com.company.jmixpm.app;

import com.company.jmixpm.security.CombinedManagerRole;
import com.company.jmixpm.security.DeveloperRole;
import com.company.jmixpm.security.FullAccessRole;
import com.google.common.collect.ImmutableMap;
import io.jmix.ldap.userdetails.LdapAuthorityToJmixRoleCodesMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Component
public class AppLdapRoleMapper implements LdapAuthorityToJmixRoleCodesMapper {

    private final static Map<String, String> roleCodes = ImmutableMap.of(
            "admin", FullAccessRole.CODE,
            "developers", DeveloperRole.CODE,
            "managers", CombinedManagerRole.CODE
    );

    @Override
    public Collection<String> mapAuthorityToJmixRoleCodes(String authority) {
        return Collections.singletonList(roleCodes.getOrDefault(authority, authority));
    }
}
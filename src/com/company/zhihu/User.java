package com.company.zhihu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {
    private String id;

    private String name;

    private List<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    static class Role{
        private String rid;
        private String rname;
        private String uid;

        public String getRid() {
            return rid;
        }

        public void setRid(String rid) {
            this.rid = rid;
        }

        public String getRname() {
            return rname;
        }

        public void setRname(String rname) {
            this.rname = rname;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }

    public void match() {

// 这里的users没有role
        List<User> users = getUsers();
// 这里模糊从数据库根据UID查询role
        List<Role> roles = getRaole();

 //两次for循环，赋值
        Map<String, List<Role>> groupingRoleMap = roles.stream()
                                                       .collect(Collectors.groupingBy(Role::getUid));
        users.forEach(user -> {
            user.setRoles(groupingRoleMap.get(user.id));
        });
    }

    public void match2() {
        // 这里的users没有role
        List<User> users = getUsers();
// 这里模糊从数据库根据UID查询role
        List<Role> roles = getRaole();

// 两次for循环，赋值
        users.forEach(user -> {
            List<Role> list = new ArrayList<>();
            roles.forEach(role -> {
                if (user.getId().equals(role.getUid())){
                    list.add(role);
                }
            });
            user.setRoles(list);
        });
    }


    private static List<User> getUsers() {
        List<User> list = new ArrayList<>(2);
        for (int i = 1; i <= 2; i++) {
            User user = new User();
            user.setId(String.valueOf(i));
            user.setName(String.valueOf(i));
            list.add(user);
        }
        return list;
    }

    private static List<Role> getRaole() {
        List<Role> list = new ArrayList<>(4);
        for (int i = 1; i <= 4; i++) {
            Role role = new Role();
            role.setRid(String.valueOf(i));
            role.setRname(String.valueOf(i));
            int uid;
            if ( i % 2 == 0){
                uid =1;
            } else {
                uid =2;
            }
            role.setUid(String.valueOf(uid));
            list.add(role);
        }
        return list;
    }
}

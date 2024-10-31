package com.Jean.Supermercado;

import com.Jean.Supermercado.persistence.entities.PermissionEntity;
import com.Jean.Supermercado.persistence.entities.RoleEntity;
import com.Jean.Supermercado.persistence.entities.RoleEnum;
import com.Jean.Supermercado.persistence.entities.UserEntity;
import com.Jean.Supermercado.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SupermercadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupermercadoApplication.class, args);

	}

//	@Bean
//	CommandLineRunner init(UserRepository userRepository){
//
//		return args -> {
//
//			// CREATE PERMISSION
//			PermissionEntity createPermission=PermissionEntity.builder()
//					.name("CREATE")
//					.build();
//
//			PermissionEntity readPermission=PermissionEntity.builder()
//					.name("READ")
//					.build();
//
//			PermissionEntity updatePermission=PermissionEntity.builder()
//					.name("UPDATE")
//					.build();
//
//			PermissionEntity deletePermission=PermissionEntity.builder()
//					.name("DELETE")
//					.build();
//
//			PermissionEntity refactorPermission=PermissionEntity.builder()
//					.name("REFACTOR")
//					.build();
//
//			//CREATE ROLES
//			RoleEntity roleAdmin = RoleEntity.builder()
//					.roleEnum(RoleEnum.ADMIN)
//					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission ))
//					.build();
//
//			RoleEntity roleUser = RoleEntity.builder()
//					.roleEnum(RoleEnum.USER)
//					.permissionList(Set.of(createPermission, readPermission ))
//					.build();
//
//			RoleEntity roleInvited = RoleEntity.builder()
//					.roleEnum(RoleEnum.INVITED)
//					.permissionList(Set.of(readPermission))
//					.build();
//
//			RoleEntity roleDeveloper = RoleEntity.builder()
//					.roleEnum(RoleEnum.DEVELOPER)
//					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission ))
//					.build();
//
//			//CREATE USERS
//			UserEntity userJean = UserEntity.builder()
//					.username("jean")
//					.password("$2a$10$4gmCtW3yXmgrsFLMlbwWU.99pd8qjS96pFEtDqMVkYj3307E7Nuhi")
//					.isEnabled(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(roleDeveloper))
//					.build();
//
//			UserEntity userBruno = UserEntity.builder()
//					.username("bruno")
//					.password("$2a$10$4gmCtW3yXmgrsFLMlbwWU.99pd8qjS96pFEtDqMVkYj3307E7Nuhi")
//					.isEnabled(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(roleAdmin))
//					.build();
//
//
//			UserEntity userMati = UserEntity.builder()
//					.username("mati")
//					.password("$2a$10$4gmCtW3yXmgrsFLMlbwWU.99pd8qjS96pFEtDqMVkYj3307E7Nuhi")
//					.isEnabled(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(roleInvited))
//					.build();
//
//			userRepository.saveAll(List.of(userMati, userBruno, userJean));
//		};
//	}

}

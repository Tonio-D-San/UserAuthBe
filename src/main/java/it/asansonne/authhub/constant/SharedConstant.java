package it.asansonne.authhub.constant;

import java.util.UUID;

/**
 * The interface Shared constant.
 */
public interface SharedConstant {
  String API = "api";
  String API_VERSION = "v1";
  String DEVELOP_ROLES = "hasRole('ROLE_developer')";
  String ALA_ROLES = "hasRole('ROLE_ala')";
  String ADMIN_ROLES = "hasRole('ROLE_client_admin')";
  String COMMUNITY_ROLES = "hasRole('ROLE_community')";
  String CORONOR_ROLES = "hasRole('ROLE_coronor')";
  String LEVALIA_ROLES = "hasRole('ROLE_levalia')";
  String MALATEA_ROLES = "hasRole('ROLE_malatea')";
  String PNG_ROLES = "hasRole('ROLE_png')";
  String PG_ROLES = "hasRole('ROLE_pg')";
  String TAL_MERIDIA_ROLES = "hasRole('ROLE_tal-meridia')";
  String VALMORA_ROLES = "hasRole('ROLE_valmora')";
  String TEAM_SOCIAL_ROLES = "hasRole('ROLE_team-social')";
  String MASTER_ROLES = "hasRole('ROLE_masters')";
  String ADMIN_GROUP = "admin-service-administrators";
  UUID DEFAULT_GROUP = UUID.fromString("7de6d481-9da9-4bcc-aca2-30073030ae9d");
}

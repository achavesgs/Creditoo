package com.achavesgs.gitapi.entities;

public class User {
		
		private int id;
		private String login;
		private String name;
		private String avatar_url;
		private String html_url;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAvatar_url() {
			return avatar_url;
		}
		public void setAvatar_url(String avatar_url) {
			this.avatar_url = avatar_url;
		}
		public String getHtml_url() {
			return html_url;
		}
		public void setHtml_url(String html_url) {
			this.html_url = html_url;
		}

}

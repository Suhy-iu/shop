package cn.edu.guet.roles;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.guet.web.servlet.base.BaseServlet;


public class RoleController extends BaseServlet {
	private static final long serialVersionUID = 1L;


	public String viewRole(HttpServletRequest request, HttpServletResponse response){
		IRoleService roleService=new RoleServiceImpl();
		List<Roles> roles=roleService.getAllRole();
		request.setAttribute("roles", roles);
		return "role/viewRole.jsp";
	}
	
	public String grantRole(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		String rolesId=request.getParameter("rolesId");
		String rolesName=request.getParameter("rolesName");
		rolesName=new String(rolesName.getBytes("ISO-8859-1"),"GBK");
		System.out.print(rolesName);
		request.setAttribute("rolesId",rolesId);
		request.setAttribute("roleName",rolesName);
		return "role/grantRole.jsp";
	}
	
	public void saveGrant(HttpServletRequest request, HttpServletResponse response){
		try {
			String roleId=request.getParameter("roleId");
			String permissionIds[]=request.getParameterValues("permissionIds[]");
			IRoleService roleService=new RoleServiceImpl();
			roleService.saveGrant(roleId, permissionIds);
			System.out.println(permissionIds[0]);
			response.setContentType("text/plain;charset=GBK");
			PrintWriter out=response.getWriter();
			out.write("��Ȩ�ɹ�,�����µ�¼");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
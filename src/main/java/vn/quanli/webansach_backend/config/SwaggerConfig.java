package vn.quanli.webansach_backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "📚 Webansach - Bookstore Management API",
        version = "1.0",
        description = """
            **API Quản lý Cửa hàng Sách Trực tuyến**
            
            ### 🎯 Các chức năng chính:
            - 🔐 **Authentication**: JWT Bearer Token
            - 📖 **Quản lý sách**: CRUD operations cho sách và danh mục  
            - 🛒 **Đơn hàng**: Tạo và quản lý đơn hàng
            - 👥 **Phân quyền**: Admin, Staff, User
            - 📊 **Báo cáo**: Thống kê bán hàng
            
            ### 🔑 Phân quyền người dùng:
            - **👑 ADMIN**: Toàn quyền quản lý hệ thống
            - **👨‍💼 STAFF**: Quản lý sách, đơn hàng, khách hàng  
            - **👤 USER**: Đặt hàng, quản lý thông tin cá nhân
            
            ### 🚀 Hướng dẫn xác thực:
            1. **Đăng nhập**: POST `/api/auth/login` với username/password
            2. **Lấy token**: Copy `accessToken` từ response JSON
            3. **Click Authorize**: Nút 🔒 ở trên cùng
            4. **Nhập token**: Dán token vào ô Bearer Authentication  
            5. **Xác nhận**: Click "Authorize" để áp dụng
            """,
       
        license = @License(
            name = "MIT License",
            url = "https://opensource.org/licenses/MIT"
        )
    ),
    servers = {
        @Server(
            url = "http://localhost:8080",
            description = "🛠️ Development Server"
        ),
        @Server(
            url = "https://api.webansach.com", 
            description = "🚀 Production Server"
        )
    },
    security = @SecurityRequirement(name = "Bearer Authentication")
)
@SecurityScheme(
    name = "Bearer Authentication",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    scheme = "bearer",
    in = SecuritySchemeIn.HEADER,
    description = "Sử dụng JWT Bearer Token để xác thực. Copy token từ response của API login và thêm vào header 'Authorization: Bearer {token}'"
)
public class SwaggerConfig {
   
}
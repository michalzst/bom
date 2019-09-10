package bom.user;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class UserContextService {
    @Autowired
    private UsersRepository<User> usersRepository;

    private static Gson gson = new Gson();
    private User user;

    public String getLoggedUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }
        return authentication.getName();
    }

    public boolean admin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().stream().anyMatch(e -> RoleTypeEnum.ADMIN.getRoleName().equalsIgnoreCase(e.getAuthority()))) {
            return true;
        }
        return false;
    }

    public boolean bomUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().stream().anyMatch(e -> RoleTypeEnum.BOM.getRoleName().equalsIgnoreCase(e.getAuthority()))) {
            return true;
        }
        return false;
    }

    public String getUserFirstName(){
        return usersRepository.findByUsername(getLoggedUserEmail()).get().getFirstName();
    }

    public String getUserSurName(){
        return usersRepository.findByUsername(getLoggedUserEmail()).get().getSurName();

    }

    public void getCurrentBomUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().stream().anyMatch(e -> RoleTypeEnum.BOM.getRoleName().equalsIgnoreCase(e.getAuthority()))) {
            System.out.println();
        }
    }

    public boolean logistykaUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().stream().anyMatch(e -> RoleTypeEnum.LOGISTYKA.getRoleName().equalsIgnoreCase(e.getAuthority()))) {
            return true;
        }
        return false;
    }


    public void getCurrentLogistykaUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().stream().anyMatch(e -> RoleTypeEnum.LOGISTYKA.getRoleName().equalsIgnoreCase(e.getAuthority()))) {
            System.out.println();
        }
    }
}

/*
 * package com.expenseManager.GenericExpenseManagerModule.configurations;
 * 
 * import java.io.IOException; import java.util.List; import
 * java.util.stream.Collectors;
 * 
 * import javax.servlet.FilterChain; import javax.servlet.ServletException;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.web.filter.OncePerRequestFilter;
 * 
 * import com.expenseManager.GenericExpenseManagerModule.modals.jwtConfig;
 * 
 * import io.jsonwebtoken.Claims; import io.jsonwebtoken.Jwts;
 * 
 * public class JwtTokenAutenticationFilter extends OncePerRequestFilter {
 * 
 * private jwtConfig jwtConfig;
 * 
 * public JwtTokenAutenticationFilter(jwtConfig jwtConfig) { this.jwtConfig =
 * jwtConfig; }
 * 
 * @Override protected void doFilterInternal(HttpServletRequest request,
 * HttpServletResponse response, FilterChain filterChain) throws
 * ServletException, IOException {
 * 
 * //Tokens are typically passed in the authentication header with prefix Bearer
 * String header = request.getHeader(jwtConfig.getHeader());
 * 
 * if(header==null||!header.startsWith(jwtConfig.getPrefix())) { // its an error
 * filterChain.doFilter(request, response); return; }
 * 
 * //getting the tokens String token = header.replace(jwtConfig.getPrefix(),
 * "");
 * 
 * Claims claims = Jwts.parser().setSigningKey(jwtConfig.getSecret().getBytes())
 * .parseClaimsJws(token).getBody();
 * 
 * String userName = claims.getSubject();
 * 
 * if(userName!=null) { List<String> authorities = (List<String>)
 * claims.get("authorities"); UsernamePasswordAuthenticationToken auth = new
 * UsernamePasswordAuthenticationToken(userName, null,
 * authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.
 * toList()));); // Now, user is authenticated
 * SecurityContextHolder.getContext().setAuthentication(auth); }
 * 
 * 
 * // go to the next filter in the filter chain filterChain.doFilter(request,
 * response); }
 * 
 * }
 */
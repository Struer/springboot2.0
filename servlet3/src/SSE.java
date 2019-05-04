
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SSE
 */
@WebServlet("/SSE")
public class SSE extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SSE() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 实现SSE基本的流程：
	 * 设置ContentType和编码UTF-8，指定事件标识，每次返回的数据格式：data: + 数据 + 2个回车
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/event-stream");
		response.setCharacterEncoding("utf-8");

		for (int i = 0; i < 5; i++) {
			// 指定事件标识
			response.getWriter().write("event:me\n");
			// 格式: data: + 数据 + 2个回车
			response.getWriter().write("data:" + i + "\n\n");
			response.getWriter().flush();

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

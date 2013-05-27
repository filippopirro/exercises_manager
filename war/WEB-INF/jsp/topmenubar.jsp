<div id="mainContainer">
	<img src="./resources/images/logo_01.png">
	<div id="dhtmlgoodies_menu">
		<ul>
			<li><a href="navigation.htm?page=main.htm">Main</a>
			</li>
			<li><a href="">Activities</a>
				<ul>
					<li><a href="">Primitive types</a>
					</li>
					<c:if test="${dataCart.dataCart_loggedIn == true}">
						<li><a href="">Thread</a>
						</li>
						<li><a href="">Web services</a>
						</li>
						<li><a href="">JMS</a>
						</li>
					</c:if>
				</ul>
			</li>
			<li><a href="" onclick="return false;">Users area</a>
				<ul>
					<c:choose>
						<c:when test="${dataCart.dataCart_loggedIn == false}">
							<li><a href="navigation.htm?page=register.htm">Register new user</a>
							</li>
							<li><a href="navigation.htm?page=login.htm">Login</a>
							</li>
						</c:when>
						<c:otherwise>
							<li><a href="navigation.htm?page=updateuser.htm">Update user</a>
							</li>
							<li><a href="navigation.htm?page=deleteuser.htm">Delete user</a>
							</li>
							<li><a href="navigation.htm?page=logout.htm">Logout</a>
							</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</li>
			<li>&nbsp;&nbsp;&nbsp;&nbsp;
				<c:if test="${dataCart.dataCart_loggedIn == true}">
					Welcome ${dataCart.dataCart_username}
				</c:if>
			</li>
		</ul>
		
	</div>
	</p>
</div>

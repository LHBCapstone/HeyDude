import React from "react";
import "../style.css";
import { Link } from "react-router-dom";

function Nav() {
  return (
    <div className="nav">
      <div className="container">
        <div className="logo">
          <Link className="toHome" to="/main">
            <h1>홈</h1>
          </Link>
        </div>
        <div className="nav-menu" id="bs-example-navbar-collapse-1">
          <ul className="nav navbar-nav navbar-right main_menu">
            <li>
              <Link className="toGuide" to="/guide">
                가이드
              </Link>
            </li>
            <li>
              <Link className="toExperience" to="/experience">
                경험
              </Link>
            </li>
            <li>
              <Link className="toPlan" to="/plan">
                플랜
              </Link>
            </li>
            <li>
              <Link className="toCompanion" to="/companion">
                동행
              </Link>
            </li>
          </ul>
        </div>
        <div className="login">
          <Link to="/login">로그인</Link>
          <Link className="join-form-link" to="/join">
            회원가입
          </Link>
        </div>
      </div>
    </div>
  );
}

export default Nav;

import {NavLink, Outlet} from "react-router-dom";
import {createMenuItems} from "@vaadin/hilla-file-router/runtime.js";

export default function Layout() {
    return (
        <div>
            <nav className="flex gap-s p-m">
                {createMenuItems().map(
                    item => (
                        <NavLink to={item.to}>{item.title}</NavLink>
                    )
                )}
            </nav>
            <main>
                <Outlet/>
            </main>
        </div>
    );
}

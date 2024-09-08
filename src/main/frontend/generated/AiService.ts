import { Subscription as Subscription_1 } from "@vaadin/hilla-frontend";
import client_1 from "./connect-client.default.js";
function getCompilation_1(prompt: string): Subscription_1<string> { return client_1.subscribe("AiService", "getCompilation", { prompt }); }
export { getCompilation_1 as getCompilation };

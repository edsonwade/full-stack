import {Button, TextField} from "@vaadin/react-components";
import React, {useState} from "react";
import {AiService} from "Frontend/generated/endpoints";
import Markdown from "react-markdown";


export default function AiChat() {
    const [prompt, setPrompt] = useState<string>("");

    const [response, setResponse] = useState<string>("")

    async function send() {
        try {
            AiService.getCompilation(prompt).onNext(token => setResponse(res => res + token));

        } catch (err) {
            console.error("Error:", err);
            setResponse("An error occurred while sending the request.")
        }
    }

    return (
        <div className="p-m">
            <h1>Welcome to the AI Chat App</h1>

            <div>
                <TextField placeholder="Ask me anthing" value={prompt} onChange={(e) => setPrompt(e.target.value)}/>
            </div>
            <Button onClick={send}>Send</Button>

            <Markdown>
                {response}
            </Markdown>
        </div>
    );
}
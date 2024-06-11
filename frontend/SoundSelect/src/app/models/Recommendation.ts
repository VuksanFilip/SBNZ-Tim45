import { Song } from "./Song";

export interface Recommendation {
    explanation: string;
    recommendedSongs: Song[];
}
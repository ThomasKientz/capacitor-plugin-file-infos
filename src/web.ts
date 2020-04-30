import { WebPlugin } from '@capacitor/core';
import { FileInfosPlugin } from './definitions';

export class FileInfosWeb extends WebPlugin implements FileInfosPlugin {
  constructor() {
    super({
      name: 'FileInfos',
      platforms: ['web']
    });
  }
  
  async getInfos(): Promise<any> {
    throw new Error("Method not implemented.");
  }
}

const FileInfos = new FileInfosWeb();

export { FileInfos };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(FileInfos);
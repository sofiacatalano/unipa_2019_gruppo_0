export interface FileModel {
  name: string;
  size?: string;
  id?: number;
}

export class FileModelImpl implements FileModel{
  name: string;
  size: string;
  id: number;
  constructor(){}
}

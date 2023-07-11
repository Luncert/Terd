declare module 'terd' {

  /**
   * An object that can be disposed via a dispose function.
   */
  export interface IDisposable {
    dispose(): void;
  }

  /**
   * An event that can be listened to.
   * @returns an `IDisposable` to stop listening.
   */
  export interface IEvent < T > {
    (listener: (e: T) => any): IDisposable;
  }
}